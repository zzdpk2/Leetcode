#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
    };

    bool checkBST(TreeNode* root, long leftVal, long rightVal) {
        if (!root)
            return true;
        int curVal = root->val;
        if (curVal<=leftVal || curVal>=rightVal)
            return false;
        return checkBST(root->left, leftVal, curVal) && checkBST(root->right, curVal, rightVal);
    }
    bool isValidBST(TreeNode* root) {
        return checkBST(root,LONG_MIN,LONG_MAX);
    }
    return 0;

}
