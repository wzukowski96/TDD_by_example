class TestResult:
    def summary(self):
        return "1 run, 0 failed"
    def __init__(self):
        self.runCount= 0
        self.errorCount= 0
    def testStarted(self):
        self.runCount= self.runCount + 1
    def summary(self):
        return "%d run, %d failed" % (self.runCount, self.failureCount)
    def testFailed(self):
        self.errorCount= self.errorCount + 1
