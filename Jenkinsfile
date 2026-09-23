pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
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

        stage('Deploy Redis') {
            steps {
                bat '''
                    podman rm -f redis 2>NUL || exit /b 0
                    podman run -d --name redis -p 6379:6379 redis:latest
                '''
            }
        }

        stage('Deploy Order Service') {
            steps {
                bat '''
                    podman rm -f order-service 2>NUL || exit /b 0
                    podman run -d --name order-service -p 8080:8080 order-service:latest
                '''
            }
        }
    }
}
