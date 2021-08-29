class TestCase:
    def __init__(self, name):
        self.name= name
    def run(self):
        exec("self." + self.name + "()")
    def setUp(self):
        pass
    def run(self):
        self.setUp()
        exec("self." + self.name + "()")