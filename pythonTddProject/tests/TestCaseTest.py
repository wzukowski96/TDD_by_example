from files.TestCase import TestCase
from files.TestResult import TestResult
from files.TestSuite import TestSuite
from files.WasRun import WasRun


class TestCaseTest(TestCase):
    # def setUp(self):
    #     self.test= WasRun("testMethod")
    # # def testTemplateMethod(self):
    # #      self.test.run()
    # #      assert("setUp testMethod " == self.test.log)
    # def testTemplateMethod(self):
    #     test= WasRun("testMethod")
    #     test.run()
    #     assert("setUp testMethod tearDown " == test.log)
    # def testRunning(self):
    #     test= WasRun("testMethod")
    #     test.run()
    #     assert(test.wasRun)
    # # def testSetUp(self):
    # #     test= WasRun("testMethod")
    # #     test.run()
    # #     assert(test.wasSetUp)
    # def testSetUp(self):
    #     self.test.run()
    #     assert("setUp testMethod " == self.test.log)
    # def testResult(self):
    #     test= WasRun("testMethod")
    #     result= test.run()
    #     assert("1 run, 0 failed" == result.summary())
    # def testFailedResult(self):
    #     test= WasRun("testBrokenMethod")
    #     result= test.run()
    #     assert("1 run, 1 failed", result.summary)
    # def testFailedResultFormatting(self):
    #     result= TestResult()
    #     result.testStarted()
    #     result.testFailed()
    #     assert("1 run, 1 failed" == result.summary())
    # def testSuite(self):
    #     suite= TestSuite()
    #     suite.add(WasRun("testMethod"))
    #     suite.add(WasRun("testBrokenMethod"))
    #     result= TestResult()
    #     suite.run(result)
    #     assert("2 run, 1 failed" == result.summary())


    def setUp(self):
        self.result= TestResult()
    def testTemplateMethod(self):
        test= WasRun("testMethod")
        test.run(self.result)
        assert("setUp testMethod tearDown " == test.log)
    def testResult(self):
        test= WasRun("testMethod")
        test.run(self.result)
        assert("1 run, 0 failed" == self.result.summary())
    def testFailedResult(self):
        test= WasRun("testBrokenMethod")
        test.run(self.result)
        assert("1 run, 1 failed" == self.result.summary())
    def testFailedResultFormatting(self):
        self.result.testStarted()
        self.result.testFailed()
        assert("1 run, 1 failed" == self.result.summary())
    def testSuite(self):
        suite= TestSuite()
        suite.add(WasRun("testMethod"))
        suite.add(WasRun("testBrokenMethod"))
        suite.run(self.result)
        assert("2 run, 1 failed" == self.result.summary())




TestCaseTest("testRunning").run()
# print(TestCaseTest("testTemplateMethod").run().summary())
# print(TestCaseTest("testResult").run().summary())
# print(TestCaseTest("testFailedResultFormatting").run().summary())
# print(TestCaseTest("testFailedResult").run().summary())

suite= TestSuite()
suite.add(TestCaseTest("testTemplateMethod"))
suite.add(TestCaseTest("testResult"))
suite.add(TestCaseTest("testFailedResultFormatting"))
suite.add(TestCaseTest("testFailedResult"))
suite.add(TestCaseTest("testSuite"))
result= TestResult()
suite.run(result)
print(result.summary())
