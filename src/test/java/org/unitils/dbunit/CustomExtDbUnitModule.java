package org.unitils.dbunit;

import org.unitils.core.TestListener;

import java.lang.reflect.Method;

public class CustomExtDbUnitModule extends DbUnitModule {
	
	@Override
	public TestListener getTestListener() {
		final TestListener listener = super.getTestListener();
		TestListener result = new TestListener() {
			@Override
			public void beforeTestSetUp(Object testObject, Method testMethod) {
				//֮ǰ������
				beforeTestCustomSetUp(testObject, testMethod);
				listener.beforeTestSetUp(testObject, testMethod);
			}
			@Override
			public void afterTestMethod(Object testObject, Method testMethod,
					Throwable testThrowable) {
				//֮������
				afterTestCustomMethod(testObject,testMethod);
				listener.afterTestMethod(testObject, testMethod, testThrowable);
			}
		};
		return result;
	}
	
	public void beforeTestCustomSetUp(Object testObject, Method testMethod){
		//��д�Զ��崦����������
		
	}
	
	public void afterTestCustomMethod(Object testObject, Method testMethod){
		//��д�Զ��崦����������
	}
	
}
