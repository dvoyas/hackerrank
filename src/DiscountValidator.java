import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DiscountValidator {

    /// <summary>
    /// Determines whether or not a list of assignment discounts are valid
    /// </summary>
    /// <param name="assignedDiscounts">collection of DiscountAssignments that contain a mapping between DiscountId and CustomerId</param>
    /// <param name="customers">A collection of customers of the super store</param>
    /// <param name="discounts">A collection of discounts that are available to offer to customers of the super store</param>
    /// <returns><c>Boolean</c> Determines whether or not it is a valid assignment of discounts to customers</returns>
    /// <remarks>

    public static boolean validateDiscounts(List<DiscountAssignment> assignedDiscounts, List<Customer> customers, List<Discount> discounts) {
        // solution goes here

        boolean quantityExceeded = customers.stream().anyMatch(customer -> {
            List<DiscountAssignment> customerDiscounts =
                    assignedDiscounts.stream().filter(link -> link.getCustomerId() == customer.getCustomerId()).collect(Collectors.toList());
            return customerDiscounts.size() > 3;
        });
        boolean discountNotAssigned = discounts.stream().anyMatch(discount ->
                assignedDiscounts.stream().anyMatch(link -> link.getDiscountId() == discount.getDiscountId()));
        if (quantityExceeded || discountNotAssigned) {
            return false;
        }

    }
    /*public static boolean validateDiscounts(List<DiscountAssignment> assignedDiscounts, List<Customer> customers, List<Discount> discounts) {
        // solution goes here

        for (int k = 0; k < discounts.size(); k++) {
            Boolean isDiscountAssigend = false;
            for(int j = 0; j < customers.size();j++){
                int customerDiscountQuantity = 0;
                float totalCustomerDiscount = 0;
                for (int i = 0; i < assignedDiscounts.size(); i++) {
                    if(assignedDiscounts.get(i).getCustomerId() == customers.get(j).getCustomerId()){
                        customerDiscountQuantity++;

                    }
                    if (customers.get(j).getCustomerId() == assignedDiscounts.get(i).getCustomerId() && discounts.get(k).getDiscountId() ==  assignedDiscounts.get(i).getDiscountId()){
                        isDiscountAssigend = true;
                        totalCustomerDiscount = totalCustomerDiscount + discounts.get(k).getDollarValue();
                    }
                }

                if (customerDiscountQuantity > 3) return false;
                if (!isDiscountAssigend) return false;
                if (100*totalCustomerDiscount/customers.get(j).getYearlySpend() > 20) return false;
            }
        }
        return false;
    }
*/
    /* Do not modify the main method, this is just IO setup for running test cases */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean isCustomer = false;
        boolean isDiscount = false;

        List<DiscountAssignment> assignedDiscounts = new ArrayList<DiscountAssignment>();
        List<Customer> customers = new ArrayList<Customer>();
        List<Discount> discounts = new ArrayList<Discount>();
        while (scanner.hasNextLine()) {
            String arg = scanner.nextLine();
            if (arg.equals("discountAssignment")) {
                continue;
            }

            if (arg.equals("customer")) {
                isCustomer = true;
                continue;
            }

            if (arg.equals("discount")) {
                isCustomer = false;
                isDiscount = true;
                continue;
            }

            if (!isCustomer && !isDiscount) {
                int[] values = splitStr(arg);
                assignedDiscounts.add(new DiscountAssignment(values[0], values[1]));
            }
            else if (isCustomer) {
                int[] values = splitStr(arg);
                customers.add(new Customer(values[0], values[1]));
            }
            else if (isDiscount) {
                int[] values = splitStr(arg);
                discounts.add(new Discount(values[0], 0, (float)values[1]));
            }
        }

        System.out.println(validateDiscounts(assignedDiscounts, customers, discounts));
    }

    private static int[] splitStr(String arg) {
        String[] splitString = arg.split(",");
        int[] nums = new int[2];
        for (int i = 0; i < 2; i++) {
            nums[i] = Integer.parseInt(splitString[i].trim());
        }

        return nums;
    }
}

class Customer {
    private int customerId;
    private float yearlySpend;

    public Customer(int customerId, float yearlySpend) {
        this.customerId = customerId;
        this.yearlySpend = yearlySpend;
    }

    public int getCustomerId() {
        return customerId;
    }

    public float getYearlySpend() {
        return yearlySpend;
    }
}

class Discount {
    private int discountId;
    private int productId;
    private float dollarValue;

    public Discount(int discountId, int productId, float value) {
        this.discountId = discountId;
        this.productId = productId;
        this.dollarValue = value;
    }

    public int getDiscountId() {
        return discountId;
    }

    public int getProductId() {
        return productId;
    }

    public float getDollarValue() {
        return dollarValue;
    }
}

class DiscountAssignment {
    private int discountId;
    private int customerId;

    public DiscountAssignment(int discountId, int customerId) {
        this.discountId = discountId;
        this.customerId = customerId;
    }

    public int getDiscountId() {
        return discountId;
    }

    public int getCustomerId() {
        return customerId;
    }
}