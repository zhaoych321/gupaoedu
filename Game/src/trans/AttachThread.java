//package trans;
//
//import java.util.List;
//import com.sun.tools.attach.VirtualMachine; 
//
//public class AttachThread extends Thread{
//	private final List<VirtualMachineDescriptor> listBefore; 
//	 
//    private final String jar; 
//
//    AttachThread(String attachJar, List<VirtualMachineDescriptor> vms) { 
//        listBefore = vms;  // ��¼��������ʱ�� VM ����
//        jar = attachJar; 
//    } 
//
//    public void run() { 
//        VirtualMachine vm = null; 
//        List<VirtualMachineDescriptor> listAfter = null; 
//        try { 
//            int count = 0; 
//            while (true) { 
//                listAfter = VirtualMachine.list(); 
//                for (VirtualMachineDescriptor vmd : listAfter) { 
//                    if (!listBefore.contains(vmd)) { 
//// ��� VM �����ӣ����Ǿ���Ϊ�Ǳ���ص� VM ������
//// ��ʱ�����ǿ�ʼ������ VM 
//                        vm = VirtualMachine.attach(vmd); 
//                        break; 
//                    } 
//                } 
//                Thread.sleep(500); 
//                count++; 
//                if (null != vm || count >= 10) { 
//                    break; 
//                } 
//            } 
//            vm.loadAgent(jar); 
//            vm.detach(); 
//        } catch (Exception e) { 
//             ignore 
//        } 
//    } 
//    
//    public static void main(String[] args) throws InterruptedException {    
//        new AttachThread("TestInstrument1.jar", VirtualMachine.list()).start(); 
//    
//    }
//}
