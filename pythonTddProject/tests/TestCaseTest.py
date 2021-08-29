from files.TestCase import TestCase
from files.WasRun import WasRun


class TestCaseTest(TestCase):
    def setUp(self):
        self.test= WasRun("testMethod")
    # def testTemplateMethod(self):
    #      self.test.run()
    #      assert("setUp testMethod " == self.test.log)
    def testTemplateMethod(self):
        test= WasRun("testMethod")
        test.run()
        assert("setUp testMethod tearDown " == test.log)
    def testRunning(self):
        test= WasRun("testMethod")
        test.run()
        assert(test.wasRun)
    # def testSetUp(self):
    #     test= WasRun("testMethod")
    #     test.run()
    #     assert(test.wasSetUp)
    def testSetUp(self):
        self.test.run()
        assert("setUp testMethod " == self.test.log)


TestCaseTest("testRunning").run()