import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import Users.*;

import java.util.List;


/**
 * This is a test class for User subclasses/child-classes functionalities.
 * @author Christos Balaktsis
 */

public class UserTest {
    Administrator admin;
    Landlord landlord;
    Customer customer;

    @Before
    public void initializeObjects() {
        admin = new Administrator("administrator","123456");
        landlord = new Landlord("landlord","123456");
        customer = new Customer("customer","123456");
        admin.setApprovalStatus(true);
    }

    @Test
    public void setUserInfoTest() {
        assertEquals("123456",admin.getPassword());
        assertEquals("123456",landlord.getPassword());
        assertEquals("123456",customer.getPassword());

        assertEquals("administrator",admin.getUsername());
        assertEquals("landlord",landlord.getUsername());
        assertEquals("customer",customer.getUsername());

        admin.setFullName("Peter Parker");
        landlord.setFullName("Stan Lee");
        customer.setFullName("Mary Jane");
        assertEquals("Peter Parker",admin.getFullName());
        assertEquals("Stan Lee",landlord.getFullName());
        assertEquals("Mary Jane",customer.getFullName());

        admin.setFullName(null);
        assertNull(admin.getFullName());

        admin.setApprovalStatus(false);
        landlord.setApprovalStatus(true);
        customer.setApprovalStatus(true);
        assertFalse(admin.getApprovalStatus());
        assertTrue(landlord.getApprovalStatus());
        assertTrue(customer.getApprovalStatus());

        assertNull(landlord.getBase());
        landlord.setBase("Thessaloniki, Greece");
        assertEquals("Thessaloniki, Greece",landlord.getBase());

        assertNull(customer.getAddress());
        customer.setAddress("Athens, Greece");
        assertEquals("Athens, Greece",customer.getAddress());

        assertTrue(admin.setPassword("test0test!"));
        assertTrue(landlord.setPassword("test1test@"));
        assertFalse(landlord.setPassword("thisIsATest"));
        assertFalse(customer.setPassword("12345"));
        assertFalse(customer.setPassword(null));
    }

    @Test
    public void equalsTest() {
        Administrator admin2 = new Administrator(admin.getUsername(), admin.getPassword());
        admin2.setApprovalStatus(true);
        Administrator admin3 = new Administrator("DifferentUsername", "DifferentPassword");
        admin3.setApprovalStatus(true);

        admin.setFullName("Jeremy Clarkson");
        admin2.setFullName("Jeremy Clarkson");
        admin3.setFullName("James May");

        admin.setPassword("Speed4ndPower!");
        admin2.setPassword("Speed4ndPower!");
        admin3.setPassword("0h1GotLost?");

        assertEquals(admin, admin2);
        assertNotEquals(admin, admin3);

    }

    @Test
    public void getUsersWithApprovalTest() {
        List<User> approvedUsers = User.getUsersWithApproval(true);
        List<User> notApprovedUsers = User.getUsersWithApproval(false);

        assertTrue(approvedUsers.size() == 1 && approvedUsers.contains(admin));
        assertTrue(notApprovedUsers.size() == 2 && !notApprovedUsers.contains(admin));
    }

    @Test
    public void getUserFromUsernameTest(){
        assertEquals(admin, User.getUserFromUsername(admin.getUsername()));
        assertEquals(landlord, User.getUserFromUsername(landlord.getUsername()));
        assertEquals(customer, User.getUserFromUsername(customer.getUsername()));

        assertNull(User.getUserFromUsername("InvalidUsername"));

    }

}
