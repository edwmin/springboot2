pipeline {
    agent any
    tools {
        maven 'Maven 3.8.1'
        jdk 'JDK 1.8.0'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
