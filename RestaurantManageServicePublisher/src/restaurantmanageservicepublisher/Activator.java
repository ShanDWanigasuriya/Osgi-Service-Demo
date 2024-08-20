package restaurantmanageservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration customerServicePublishRegister;

	static BundleContext getContext() {
		return context;
	}

	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		System.out.println("Publisher Started");
		RestaurantManageService customerPublishService = new RestaurantManageServiceImpl();
		customerServicePublishRegister = context.registerService(
				RestaurantManageService.class.getName(), customerPublishService, null);
	}

	 
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Publisher Stop!");
		customerServicePublishRegister.unregister();
		
 	}

}
