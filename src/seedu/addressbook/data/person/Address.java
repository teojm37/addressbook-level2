package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTALCODE_INDEX = 3;
    
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    private boolean isPrivate;
    

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        
        String[] splitAddress = address.split("\\, ");
        String[] input = new String[4];
        
        for (int i = 0; i < splitAddress.length; i++){
        	input[i] = splitAddress[i];
        }
        
        
        block = new Block(input[BLOCK_INDEX]);
        street = new Street(input[STREET_INDEX]);
        unit = new Unit(input[UNIT_INDEX]);
        postalCode = new PostalCode(input[POSTALCODE_INDEX]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        String printingAddress = "";
        
        if (block.getBlock() != null){
        	printingAddress += block.getBlock();
        }
        if (street.getStreet() != null){
        	if (!printingAddress.equals("")){
        		printingAddress += ", ";
        	}
        	printingAddress += street.getStreet();
        }
        if (unit.getUnit() != null){
        	if (!printingAddress.equals("")){
        		printingAddress += ", ";
        	}
        	printingAddress += unit.getUnit();
        }
        if (postalCode.getPostalCode() != null){
        	if (!printingAddress.equals("")){
        		printingAddress += ", ";
        	}
        	printingAddress += postalCode.getPostalCode();
        }
        
        return printingAddress;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}