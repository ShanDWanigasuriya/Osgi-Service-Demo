package customermanagementservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class CusPubActivator implements BundleActivator {
	ServiceRegistration publishServiceRegistration;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		CusPubActivator.context = bundleContext;
		System.out.println("Publisher Start");
		CustomerManageService publisherService = new CustomerManageServiceImpl();
		publishServiceRegistration = context.registerService(CustomerManageService.class.getName(), publisherService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Publisher Stop");
		publishServiceRegistration.unregister();
	}

}
