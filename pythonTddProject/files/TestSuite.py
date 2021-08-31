from files.TestResult import TestResult


class TestSuite:
    def __init__(self):
        self.tests= []
    # def add(self, test):
    #     self.tests.append(test)

    def add(self, test):
        self.test= test
        self.tests.append(test)
    def run(self, result):
        for test in tests:
            test.run(result)