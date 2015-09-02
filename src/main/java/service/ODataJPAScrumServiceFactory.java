package service;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.Sprint;
import model.SprintUser;
import model.Task;
import model.User;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

public class ODataJPAScrumServiceFactory extends ODataJPAServiceFactory {

	private static final String PUNIT_NAME = "scrum";
	private static final int PAGE_SIZE = 50;

	/** Load Sample Data **/
	static {
		User sergey = new User();
		sergey.setId(1L);
		sergey.setName("Sergey");
		User dheeraj = new User();
		dheeraj.setId(2L);
		dheeraj.setName("Dheeraj");
		User chris = new User();
		chris.setId(3L);
		chris.setName("Chris");
		User urvi = new User();
		urvi.setId(4L);
		urvi.setName("Urvi");
		
		Sprint sprint1 = new Sprint();
		sprint1.setId(1L);
		sprint1.setName("Sprint 1");
		sprint1.setStatus("Finished");
		Calendar startDate = Calendar.getInstance();
		startDate.set(2015, 4, 8);
		sprint1.setStartDate(startDate);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2015, 3, 27);
		sprint1.setEndDate(endDate);

		SprintUser sprintUser1 = new SprintUser();
		sprintUser1.setId(1L);
		sprintUser1.setSprintId(1L);
		sprintUser1.setUserId(1L);
		sprintUser1.setCapacity(8);
		
		SprintUser sprintUser2 = new SprintUser();
		sprintUser2.setId(2L);
		sprintUser2.setSprintId(1L);
		sprintUser2.setUserId(2L);
		sprintUser2.setCapacity(7);
		
		SprintUser sprintUser3 = new SprintUser();
		sprintUser3.setId(3L);
		sprintUser3.setSprintId(1L);
		sprintUser3.setUserId(3L);
		sprintUser3.setCapacity(9);
		
		SprintUser sprintUser4 = new SprintUser();
		sprintUser4.setId(4L);
		sprintUser4.setSprintId(1L);
		sprintUser4.setUserId(4L);
		sprintUser4.setCapacity(6);
		
		
		Task task1 = new Task();
		task1.setId(1L);
		task1.setName("Design Feture1");
		task1.setSprintId(1L);
		task1.setEstimate(20);
		
		Task task2 = new Task();
		task2.setId(2L);
		task2.setName("Implement Feture1");
		task2.setSprintId(1L);
		task2.setEstimate(30);
		
		Sprint sprint2 = new Sprint();
		sprint2.setId(2L);
		sprint2.setName("Sprint 2");
		sprint2.setStatus("Planning");
		startDate = Calendar.getInstance();
		startDate.set(2015, 4, 11);
		sprint2.setStartDate(startDate);
		endDate = Calendar.getInstance();
		endDate.set(2015, 4, 29);
		sprint2.setEndDate(endDate);
		
		EntityManager em = Persistence.createEntityManagerFactory(PUNIT_NAME)
				.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(sergey);
		em.persist(dheeraj);
		em.persist(chris);
		em.persist(urvi);
		
		em.persist(sprint1);
		em.persist(sprint2);
		
		em.persist(task1);
		em.persist(task2);
		
		em.persist(sprintUser1);
		em.persist(sprintUser2);
		em.persist(sprintUser3);
		em.persist(sprintUser4);
		
		em.getTransaction().commit();
	}

	@Override
	public ODataJPAContext initializeODataJPAContext()
			throws ODataJPARuntimeException {
		ODataJPAContext oDataJPAContext = getODataJPAContext();
		oDataJPAContext.setEntityManagerFactory(Persistence
				.createEntityManagerFactory(PUNIT_NAME));
		oDataJPAContext.setPersistenceUnitName(PUNIT_NAME);

		oDataJPAContext.setPageSize(PAGE_SIZE);
		setDetailErrors(true);

		return oDataJPAContext;
	}
}
