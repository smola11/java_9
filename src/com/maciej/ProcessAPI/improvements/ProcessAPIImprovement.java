package com.maciej.ProcessAPI.improvements;

public class ProcessAPIImprovement {

    // There are 2 new interfaces in Process API to control/manage OS processes:
    //    - java.lang.ProcessHandle
    //    - java.lang.ProcessHandle.Info

    public static void main(String[] args) {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("Current Process Id: = " + currentProcess.pid());
        ProcessHandle.Info currentProcessInfo = currentProcess.info();
        System.out.println("Command: " + currentProcessInfo.command().get());
    }
}
