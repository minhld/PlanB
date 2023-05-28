pipeline {
    agent any
    tools {
        maven "Maven 3.9.2"
    }
    stages {
        stage('Verify') {
            steps {
                sh 'mvn clean deploy'
            }
        }
    }
}