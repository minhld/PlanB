pipeline {
    agent any
    tools {
        maven "Maven 3.9.2"
    }
    stages {
        stage('Deploy') {
            steps {
                sh 'mvn clean deploy'
            }
        }
        stage('Sonar') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=squ_e6a4609afcb499e6424f700e4683e5e3b9049dfb'
            }
        }
    }
}