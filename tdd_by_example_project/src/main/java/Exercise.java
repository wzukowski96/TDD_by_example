public class Exercise {
    int sum(int[] values) {
        int sum= 0;
        for (int i= 0; i<values.length; i++)
            sum += values[i];
        return sum;
    }

//    public boolean setReadOnly() {
//        SecurityManager security = System.getSecurityManager();
//        if (security != null) {
//            security.checkWrite(path);
//        }
//        return fs.setReadOnly(this);
//    }

    //LAX SECURITY
//    public void checkWrite(String path) {
//    }

//    public static SecurityManager getSecurityManager() {
//        return security != null ? security : new LaxSecurity();
//    }

//    public void runBare() throws Throwable {
//        setUp();
//        try {
//            runTest();
//        }
//        finally {
//            tearDown();
//        }
//    }

}
