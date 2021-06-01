package com.bugbounty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.bugbounty.models.Bug;
import com.bugbounty.models.Role;
import com.bugbounty.models.Solution;
import com.bugbounty.models.Status;
import com.bugbounty.models.User;
import com.bugbounty.repository.BugRepository;
import com.bugbounty.repository.SolutionRepository;
import com.bugbounty.service.BugService;
import com.bugbounty.service.SolutionService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SolutionServiceTest {

	@Mock
	private BugRepository bRepo = mock(BugRepository.class);
	private SolutionRepository sRepo = mock(SolutionRepository.class);
	private BugService bugServ = mock(BugService.class);
	private SolutionService solServ = mock(SolutionService.class);
	
	Status resolved = new Status(3, "Resolved");
	LocalDateTime date = LocalDateTime.now();
	Role role = new Role();
	User user1 = new User(1,"anyUser","123123","any", "test",role);
	Bug bug = new Bug(1,"Bug description created for testing", date, user1, resolved);
	Solution solution = new Solution(1, false, date, bug, user1);
	List<Solution> mockSolutions = new ArrayList<>();
	List<Bug> resolvedBugs = new ArrayList<>();
	List<Solution> resolvedSolutions = new ArrayList<>();
	Solution resolvedSolution1 = new Solution(2, true, date, bug, user1);
	Solution resolvedSolution2 = new Solution(3, true, date, bug, user1);
	
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockSolutions.add(solution);
		resolvedBugs.add(bug);
		resolvedSolutions.add(resolvedSolution1);
		resolvedSolutions.add(resolvedSolution2);
		when(bRepo.getById(1)).thenReturn(bug);
		when(sRepo.findByBug(bug)).thenReturn(mockSolutions);
		when(bugServ.getAllResolvedBugs()).thenReturn(resolvedBugs);
		when(solServ.getAllSolutionResolved()).thenReturn(resolvedSolutions);
		when(solServ.getAllSolutionsByUserId(user1)).thenReturn(resolvedSolutions);
	}
	
	@Test
	public void allSolutionsForBugTest() {
		Bug bug = bRepo.getById(1);
		List<Solution> solutions = sRepo.findByBug(bug);
		assertEquals(solutions, mockSolutions);
	}
	
	@Test
	public void getAllSolutionResolvedTest() {
		List<Solution> solutions = new ArrayList<>();
		solutions.add(resolvedSolution1);
		solutions.add(resolvedSolution2);
		assertEquals(solutions, resolvedSolutions);
	}
	
	@Test
	public void getAllSolutionsByUserId() {
		List<Solution> solutions = new ArrayList<>();
		solutions.add(resolvedSolution1);
		solutions.add(resolvedSolution2);
		assertEquals(solutions, resolvedSolutions);
	}
	
}
