pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                bat 'podman_compose up -d --build'
            }
        }
    }
}
