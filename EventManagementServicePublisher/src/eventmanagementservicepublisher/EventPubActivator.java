package eventmanagementservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class EventPubActivator implements BundleActivator {
	ServiceRegistration publishServiceRegistration;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		EventPubActivator.context = bundleContext;
		System.out.println("Event Publisher Start");
		EventManageService publisherService = new EventManageServiceImpl();
		publishServiceRegistration = context.registerService(EventManageService.class.getName(), publisherService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Event Publisher Stop");
		publishServiceRegistration.unregister();
	}

}
