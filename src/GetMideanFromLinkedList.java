import java.util.Scanner;

public class GetMideanFromLinkedList  
{ 
    node head = null; 
    // node a,b; 
    static class node  
    { 
        int val; 
        node next; 
  
        public node(int val)  
        { 
            this.val = val; 
        } 
    } 
      
    node sortedMerge(node a, node b)  
    { 
        node result = null; 
        if (a == null) 
            return b; 
        if (b == null) 
            return a; 
        if (a.val <= b.val)  
        { 
            result = a; 
            result.next = sortedMerge(a.next, b); 
        }  
        else 
        { 
            result = b; 
            result.next = sortedMerge(a, b.next); 
        } 
        return result; 
  
    } 
  
    node mergeSort(node h)  
    { 
        if (h == null || h.next == null) 
        { 
            return h; 
        } 
        node middle = getMiddle(h); 
        node nextofmiddle = middle.next; 
        middle.next = null; 
        node left = mergeSort(h); 
        node right = mergeSort(nextofmiddle); 
        node sortedlist = sortedMerge(left, right); 
        return sortedlist; 
    } 
    node getMiddle(node h)  
    { 
        if (h == null) 
            return h; 
        node fastptr = h.next; 
        node slowptr = h; 
        while (fastptr != null) 
        { 
            fastptr = fastptr.next; 
            if(fastptr!=null) 
            { 
                slowptr = slowptr.next; 
                fastptr=fastptr.next; 
            } 
        } 
        return slowptr; 
    } 
  
    void push(int new_data)  
    { 
        node new_node = new node(new_data); 
        new_node.next = head; 
        head = new_node; 
    } 
    public void getMedianNodeElement(node headref){
    	int count=0;
    	float midian=0;
    	node headref1=headref;
    	while (headref != null)  
        { 
            count++;
            headref = headref.next; 
        }
    	headref=headref1;
    	int temp1=count/2;
    	int temp2=0;
    	if(count%2==0) {
    		while (headref != null)  
            {
    			if(temp2==temp1-1) {
    				midian=headref.val;
    				headref = headref.next;
    				midian = (midian+headref.val)/2;
    				break;
    			}else {
    				headref = headref.next;
                    temp2++;
    			}
                
            }
    	}
    	else if(count%2!=0) {
    		headref=headref1;
			while (headref != null)  
	        {
				if(temp1==temp2) {
					System.out.println("midian val is"+headref.val);
					midian=headref.val;
				}
	            headref = headref.next; 
	            temp2++;
	        }
    	}
    	System.out.println("------"+midian);
    }
    void printlist(node head)  
    { 
        while (head != null)  
        { 
            System.out.print(head.val + " "); 
            head = head.next; 
        } 
    }
    public static void main(String[] args)  
    { 
    	GetMideanFromLinkedList li = new GetMideanFromLinkedList();
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	for(int i=0;i<n;i++)
    	{
    		li.push(sc.nextInt());
    		li.head = li.mergeSort(li.head); 
            li.getMedianNodeElement(li.head);
    	}
//        li.push(15); 
//        li.push(10); 
//        li.push(5); 
//        li.push(20); 
//        li.push(3); 
//        //li.push(2); 
  
        
    } 
} 