package roommanagementservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PublisherActivator implements BundleActivator {
	private ServiceRegistration roomManagement_Reg;
	private RoomManagementService roomService;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Room management services strating.....");
		PublisherActivator.context = bundleContext;
		
		roomService = new RoomManagementServiceImpl();
		roomManagement_Reg = context.registerService(RoomManagementService.class.getName(), roomService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		PublisherActivator.context = null;
		
		System.out.println("Room management services ending.....");
		roomManagement_Reg.unregister();
	}

}
