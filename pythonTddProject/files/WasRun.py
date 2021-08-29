from TestCase import TestCase


class WasRun(TestCase):
    def __init__(self, name):
        self.wasRun= None
        TestCase.__init__(self, name)
    def run(self):
        exec("self." + self.name + "()")
    def testMethod(self):
        self.wasRun = 1
    def setUp(self):
        self.wasRun= None
        self.wasSetUp= 1


test = WasRun("testMethod")
print(test.wasRun)
test.testMethod()
print(test.wasRun)