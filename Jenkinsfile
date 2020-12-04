pipeline {

    agent any

    stages {
        stage ('Build Stage'){
            steps{
                withMaven(maven : 'maven_3_6_2'){
                    bat ' mvn -B -DskipTests clean package'
                }
            }
        }


        stage ('Testing Stage'){
           steps{
               withMaven(maven : 'maven_3_6_2'){
                    echo '''The goal of these Tests are to see if the Bcc and Cc are working as intended'''
                    bat 'mvn test'

               }
           }
        }

        stage ('Deployment Stage'){
           steps{
               echo 'is it working?'
              bat 'deliver.sh'

           }
        }

    }


}
