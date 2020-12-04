pipeline {

    agent any

    stages {
        stage ('Build Stage'){
            steps{
                withMaven(maven : 'maven_3_6_2'){
                    echo ' mvn -B -DskipTests clean package'
                }
            }
        }


        stage ('Testing Stage'){
           steps{
               withMaven(maven : 'maven_3_6_2'){
                   echo 'mvn test'
                   echo '''The goal of these Tests are to see if the Bcc and Cc are working as intended'''
               }
           }
        }

        stage ('Deployment Stage'){
           steps{
               withMaven(maven : 'maven_3_6_2'){
                   echo 'mvn deploy'
                   echo './deliver.bash'
                   echo '''ybu288'''
               }
           }
        }

    }


}
