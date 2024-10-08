https://www.codingninjas.com/studio/problems/add-one-to-a-number-represented-as-linked-list_920557?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf


*******************************************  Brute  *************************************************************


public class Solution {

//call reverse function
    public static Node reverse(Node head) {
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }


	public static Node addOne(Node head) {
		// Write your code here.

	head = reverse(head);
		
        int carry = 1;
        Node temp = head;
        while (temp != null) 
        {
            temp.data = temp.data +  carry;

            if (temp.data < 10)
            {
                carry = 0;
                break;
            } else 
            {
                temp.data = 0;
                carry = 1;
            }

            temp = temp.next;
        }

        head = reverse(head);

        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
	}
}

**************************************************   Optimal  *********************************************************************

(------Using recursion------)

TC -O(N)  SC -O(N)

public class Solution {
	public static Node addOne(Node head) {
		// Write your code here.
		int carry = helper(head);

		if(carry == 1)
		{
			Node newNode = new Node(1);
			newNode.next = head;
			head = newNode;
		}
		return head;
	}
 public static int helper(Node head) {
        if (head == null) return 1;

        int carry = helper(head.next);
        head.data = head.data + carry;

        if (head.data < 10) return 0;

        head.data = 0;
        return 1;
    }
}
