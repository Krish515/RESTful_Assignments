package org.krish.assignment7.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.krish.assignment7.dao.AccountDAO;
import org.krish.assignment7.model.Account;

@Path("/accounts")
public class AccountService {
	@GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 public List<Account> getAccounts_JSON() {
        List<Account> listOfAccounts = AccountDAO.getAllAccount();
        return listOfAccounts;
    }
	@GET
    @Path("/{accNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Account getACBalance(@PathParam("accNo") String accNo) {
        return AccountDAO.getBalance(accNo);
    }
	@GET
	@Path("/deposit")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Account deposit(@QueryParam("acc") String acc,@QueryParam("deposit") double deposit) {
		 return AccountDAO.deposit(acc,deposit);
	 }
	@GET
	@Path("/withdraw")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Account withdraw(@QueryParam("acc") String acc,@QueryParam("withdraw") double withdraw) {
		 return AccountDAO.withdraw(acc,withdraw);
	 }
}
