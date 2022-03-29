class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *res = new ListNode(0);
        ListNode *r = l1, *s = l2, *curr = res;
        int carry = 0;
        while(r != NULL || s != NULL){
            int x = (r != NULL) ? r->val : 0;
            int y = (s != NULL) ? s->val : 0;
            int sum = carry+x+y;
            carry = sum/10;
            curr->next = new ListNode(sum%10);
            curr = curr->next;
            
            if(r != NULL) r = r->next;
               
            if(s != NULL) s = s->next;
        }
        if(carry>0){
            curr->next = new ListNode(carry);
        }
        return res->next;
        
    }
};
