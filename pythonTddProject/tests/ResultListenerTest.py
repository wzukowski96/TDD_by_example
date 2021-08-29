from files.ResultListener import ResultListener
from files.TestResult import TestResult
from files.WasRun import WasRun


class ResultListenerTest(ResultListener):
    def testNotification(self):
        self.count= 0
        result= TestResult()
        result.addListener(self)
        WasRun("testMethod").run(result)
        assert 1 == self.count
    def startTest(self):
        self.count= self.count + 1