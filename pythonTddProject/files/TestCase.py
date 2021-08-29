from files.TestResult import TestResult


class TestCase:
    def __init__(self, name):
        self.name= name
    def run(self):
        exec("self." + self.name + "()")
    def setUp(self):
        pass
    # def run(self):
    #     result= TestResult()
    #     result.testStarted()
    #     self.setUp()
    #     exec("self." + self.name + "()")
    #     self.tearDown()
    #     return result

    def run(self):
        result= TestResult()
        result.testStarted()
        self.setUp()
        try:
            exec("self." + self.name + "()")
        except:
            result.testFailed()
        self.tearDown()
        return result
    def tearDown(self):
        pass
