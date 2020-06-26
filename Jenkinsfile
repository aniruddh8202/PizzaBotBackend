pipeline {

    agent any
    tools {
        maven 'Maven' 
    }
    stages {
        stage('Compile stage') {
            steps {
                bat "mvn clean compile" 
        }
    }
	// stage("build & SonarQube analysis-----") {
 //            steps {
 //              withSonarQubeEnv('Sonar') {
 //                bat 'mvn clean package sonar:sonar'
 //              }
 //            }
	// 		}

 //         stage('testing stage') {
 //             steps {
 //                bat "mvn test"
 //                junit allowEmptyResults: true, testResults:'**/target/*.xml' 
 //        }
 //    }

          stage('Install stage') {
              steps {
                bat "mvn install"
                archiveArtifacts artifacts: '**/target/*.war', fingerprint: true 
        }
    }
	
stage('publish'){
	steps{
        nexusArtifactUploader artifacts: [[artifactId: 'Temporary', classifier: '', file: 'target/0.0.1-SNAPSHOT.war', type: 'war']], credentialsId: '1cdb8165-4cef-40e3-9883-758c30c0b791', groupId: 'com.example', nexusUrl: 'localhost:8081/', nexusVersion: 'nexus3', protocol: 'http', repository: 'http://localhost:8081/repository/Pipeline/', version: '0.0.1-SNAPSHOT'
	}
       
      }

  }
 
}