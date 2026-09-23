pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }
stage('Debug Podman') {
    steps {
        bat '''
            echo ===== USER =====
            whoami
            echo ===== PROFILE =====
            echo %USERPROFILE%
            echo ===== PODMAN VERSION =====
            podman version
            echo ===== CONNECTIONS =====
            podman system connection list
            echo ===== MACHINE =====
            podman machine list
            echo ===== PODMAN INFO =====
            podman info
        '''
    }
}
        

        stage('Build & Test') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Image') {
            steps {
                bat 'podman build -t order-service:latest .'
            }
        }
        stage('Create Network') {
    steps {
        bat '''
            podman network inspect order-network >NUL 2>&1
            if errorlevel 1 podman network create order-network
        '''
    }
}
      stage('Deploy Redis') {
    steps {
        bat '''
            podman rm -f redis 2>NUL || exit /b 0
            podman run -d --name redis --network order-network -p 6379:6379 redis:latest
        '''
    }
}

        stage('Deploy Order Service') {
    steps {
        bat '''
            podman rm -f order-service 2>NUL || exit /b 0
            podman run -d --name order-service --network order-network -p 8080:8080 order-service:latest
        '''
    }
}

        stage('Wait for Application') {
    steps {
        powershell 'Start-Sleep -Seconds 10'
        bat 'podman logs email-service-test'
    }
}

        stage('Test Spring Boot API') {
    steps {
        bat '''
            timeout /t 10 /nobreak >NUL
            curl.exe -f http://localhost:8080/getString
        '''
    }
}
    }
}
