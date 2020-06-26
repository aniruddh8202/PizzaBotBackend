pipeline {

    agent any
    tools {
        Maven 
    }
    stages {
        stage('Compile stage') {
            steps {
                sh "mvn clean compile" 
        }
    }
	stage("build & SonarQube analysis-----") {
            steps {
              withSonarQubeEnv('Sonar') {
                sh 'mvn clean package sonar:sonar'
              }
            }
			}

         stage('testing stage') {
             steps {
                sh "mvn test"
                junit allowEmptyResults: true, testResults:'**/target/*.xml' 
        }
    }

          stage('Install stage') {
              steps {
                sh "mvn install"
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
        }
    }
	


  }
 
}