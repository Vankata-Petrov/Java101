package week5.friday.bank.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import week5.friday.bank.Interest;
import week5.friday.bank.enums.OperationType;
import week5.friday.bank.exception.InsufficientAvailabilityException;
import week5.friday.bank.util.MessageConstants;

public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	private double money;
	private long id;
	private String password;
	private Person person;
	private Interest interest;
	private History history;
	private List<History> accountHistory;

	public class History implements Serializable {
		private static final long serialVersionUID = 8743656606584303715L;
		private OperationType operationType;
		private String message;
		private double addedOrTransferedMoney;
		private BankAccount transferAccount;

		public History(OperationType operationType, double money) {
			addedOrTransferedMoney = money;
			this.operationType = operationType;
			message = addedOrTransferedMoney + operationType.getMessage();
		}

		public History(BankAccount account, OperationType operationType, double money) {
			transferAccount = account;
			addedOrTransferedMoney = money;
			this.operationType = operationType;
			message = addedOrTransferedMoney + operationType.getMessage() + transferAccount.getPerson();
		}

		public String getMessage() {
			return message;
		}
	}

	public BankAccount(Person person) {
		this.person = person;
		accountHistory = new ArrayList<>(5);
		money = 0.0;
	}

	public Person getPerson() {
		return person;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(OperationType type, double money) {
		switch (type) {
		case ADD:
			this.money += money;
			break;
		case WITHDRAW:
			this.money -= money;
			break;
		case TRANSFER:
			this.money -= money;
			break;
		default:
			break;
		}
	}

	public History getOperationHistory() {
		return history;
	}

	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}

	public void showHistory() {
		if (accountHistory.isEmpty()) {
			System.err.println("History is empty");
		} else {
			for (History history : accountHistory) {
				System.out.println(history.operationType + ":" + history.getMessage());
			}
		}
	}

	public Double getBalance() throws InsufficientAvailabilityException {
		if (money > 0) {
			System.out.println(MessageConstants.BALANCE_MESSAGE + money);
			return money;
		}
		throw new InsufficientAvailabilityException("Zero balance" + money);
	}

	public void addToHistory(History history) {
		if (accountHistory.size() == 5) {
			accountHistory.remove(0);
		}
		accountHistory.add(history);
	}

	@Override
	public String toString() {
		return "BankAccount [ID=" + getID() + " " + getPerson() + " " + interest + ", money=" + money + "]";
	}
}
