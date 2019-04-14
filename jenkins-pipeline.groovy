node {
    stage ('Clone repo') {
        echo 'Step - clone repo'
        git 'https://github.com/Chriton/jenkins-test.git'
        // git https://source.int.netcentric.biz/git/scm/aut/dhl-test-automation.git
        // branch:  */test-jenkins
    }

    stage ('Build') {
        echo 'Maven build'

//        steps {
//            withMaven(maven: 'maven_3_3_9') {
//                sh 'mvn clean install'
//            }
//        }
    }

    stage ('Run tests') {
        echo 'Run tests'

//        steps {
//            withMaven(maven: 'maven_3_3_9') {
//                sh 'mvn -PrunITs'
//            }
//        }
    }


    stage ('Send Slack notification') {
        // process cucumber reports

        // send report to slack
        cucumberSlackSend channel:'qa', json:'target/test-results.json'
    }
}