class Solution {
public:
	ListNode* partition(ListNode* head, int x) {
        ListNode* curr=head;
        vector<int> v,n;
        while(curr!=nullptr){   //loop to put values from linkedlist into vector
            n.push_back(curr->val);
            curr=curr->next;
        }
        for(int j=0;j<n.size();j++){    //pushing the values less than 'x' in a vector
            if(n[j]<x){
                v.push_back(n[j]);
            }
        }
        for(int j=0;j<n.size();j++){    //pushing the values equal or greater than 'x' in a vector
            if(n[j]>=x){
                v.push_back(n[j]);
            }
        }
        ListNode* root= nullptr;
        for(int i=0;i<v.size();i++){    //putting values from vector in the linkedlist
            if(root==nullptr){
                root= new ListNode(v[i]);
                continue;
            }
            ListNode* curr=root;
            while(curr->next!=nullptr){
                curr=curr->next;
            }
            curr->next=new ListNode(v[i]);
        }
        return root;
    }
};
