pipeline {
    agent any
    tools {
        maven "Maven 3.9.2"
    }
    stages {
        stage('Verify') {
            steps {
                sh 'mvn clean verify'
            }
        }
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/minhld/PlanB.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
    }
}