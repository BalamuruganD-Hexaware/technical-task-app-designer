package com.technical-task-app-designer.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.technical-task-app-designer.controller.EmployeeController;
import com.technical-task-app-designer.entity.Employee;
import com.technical-task-app-designer.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
	@Mock
	private EmployeeService service;

	@InjectMocks
	private EmployeeController controller;
	
	private List<Employee> prepareEmployeeRecords(){
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee1 = new Employee("62d6b821618d9f7c7024ccc5", "NasjG","1FXNM");
		Employee employee2 = new Employee("62d6b821618d9f7c7024ccc4", "ffd1R","tuUGj");
		employeeList.add(employee1);
		employeeList.add(employee2);
		return employeeList;
	}
	
	@Test
	public void testFetchAllPass() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareEmployeeRecords());
		List<Employee> employeeList = prepareEmployeeRecords();
		List<Employee> employeeListFromController =  controller.fetchAll();
		for(int i=0; i<employeeList.size();i++) {
			Assertions.assertEquals(employeeList.get(i).getId(), employeeListFromController.get(i).getId());
            Assertions.assertEquals(employeeList.get(i).getName(), employeeListFromController.get(i).getName());
            Assertions.assertEquals(employeeList.get(i).getEmail(), employeeListFromController.get(i).getEmail());
		}
		
	}

	@Test
	public void testFetchAllFailure() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareEmployeeRecords());
		List<Employee> employeeList = null; //Intentionally made null to fail the test.
		List<Employee> employeeListFromController =  controller.fetchAll();
		Assertions.assertNotEquals(employeeList, employeeListFromController);
	}
	
	
	 @Test public void fetchByIdPass() { 
		 Mockito
	        .when(controller.fetchById("62d6b821618d9f7c7024ccc5"))
            .thenReturn(prepareEmployeeRecords().get(0));

        Employee employeeById = prepareEmployeeRecords().get(0);
        Employee employeeByIdFromController = controller.fetchById("62d6b821618d9f7c7024ccc5");
        
        Assertions.assertEquals(employeeById.getId(), employeeByIdFromController.getId());
        Assertions.assertEquals(employeeById.getName(), employeeByIdFromController.getName());
        Assertions.assertEquals(employeeById.getEmail(), employeeByIdFromController.getEmail());
		 
	 }

	 @Test public void fetchByIdFailure() { 
		Mockito
	        .when(controller.fetchById("62d6b821618d9f7c7024ccc5"))
            .thenReturn(prepareEmployeeRecords().get(0));

        Employee employeeById = prepareEmployeeRecords().get(1);
        Employee employeeByIdFromController = controller.fetchById("62d6b821618d9f7c7024ccc5");
        
        Assertions.assertNotEquals(employeeById.getId(), employeeByIdFromController.getId());
        Assertions.assertNotEquals(employeeById.getName(), employeeByIdFromController.getName());
        Assertions.assertNotEquals(employeeById.getEmail(), employeeByIdFromController.getEmail());
		 
	 }
	 
	 @Test
	 public void deletePass() { 
		 controller.delete("62d6b821618d9f7c7024ccc5");
		 Assertions.assertTrue(true); // This line will be executed only if there is no error in calling the controller for delete as there is no return value.
	 }

	@Test
	public void createPass() {
		Employee employeeToBeCreated 			= prepareEmployeeRecords().get(0);
		Employee employeeReturned = prepareEmployeeRecords().get(0);
		employeeReturned.setId("62d6b821618d9f7c7024ccc9"); //Changed the ID.
		
		Mockito
			.when(controller.create(employeeToBeCreated))
            .thenReturn(employeeReturned);
		
		Employee employeeFromController  = controller.create(employeeToBeCreated);
		Assertions.assertNotEquals(employeeToBeCreated.getId(), employeeFromController.getId()); //Since Id of created one is mocked as changed from within serviceid, it cannot be equal.
        Assertions.assertEquals(employeeToBeCreated.getName(), employeeFromController.getName());
        Assertions.assertEquals(employeeToBeCreated.getEmail(), employeeFromController.getEmail());
	}
	
	@Test
	public void createFailure() {
		Employee employeeToBeCreated = prepareEmployeeRecords().get(0);
		Employee employeeReturned = null; // Intentionally left to null to fail the case. 
				
		Mockito
			.when(controller.create(employeeToBeCreated))
            .thenReturn(employeeReturned);
		
		Employee employeeFromController  = controller.create(employeeToBeCreated);
		Assertions.assertNull(employeeFromController);
	}
}
