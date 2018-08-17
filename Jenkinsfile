node {
    def mvnHome = tool 'Maven'

    // Mark the code checkout 'stage'....
    stage 'Checkout'
    // Get some code from a GitHub repository
    git url: 'https://github.com/enriquegh/Java-Junit-Appium-Android.git'
    stage 'Compile'
    sh "${mvnHome}/bin/mvn compile"
    stage 'Test'
    sauce('saucelabs') {
        sauceconnect(useGeneratedTunnelIdentifier: true, verboseLogging: true) {
            sh "${mvnHome}/bin/mvn test"
        }
    }
    stage 'Collect Results'
    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
    step([$class: 'SauceOnDemandTestPublisher'])
}