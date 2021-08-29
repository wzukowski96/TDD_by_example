from TestCase import TestCase


class WasRun(TestCase):
    def __init__(self, name):
        self.wasRun= None
        TestCase.__init__(self, name)
    def run(self):
        exec("self." + self.name + "()")
    # def testMethod(self):
    #     self.wasRun= 1
    #     self.log= self.log + "testMethod "
    # def setUp(self):
    #     self.wasRun= None
    #     self.wasSetUp= 1
    #     self.log= "setUp "


    # def setUp(self):
    #     self.log= "setUp "
    # def testMethod(self):
    #     self.log= self.log + "testMethod "
    # def tearDown(self):
    #     self.log= self.log + "tearDown "

    def setUp(self):
        self.log= "setUp "
    def testMethod(self):
        self.log= self.log + "testMethod "
    def tearDown(self):
        self.log= self.log + "tearDown "

    def testBrokenMethod(self):
        raise Exception



test = WasRun("testMethod")
print(test.wasRun)
test.testMethod()
print(test.wasRun)