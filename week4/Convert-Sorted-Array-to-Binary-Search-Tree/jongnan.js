var sortedArrayToBST = function (nums) {
	/* 
    #=====================================================================# 
    | 처음 접근 방식                                                      | 
    |---------------------------------------------------------------------|
    | 가운데 숫자가 루트 노드가 되며 루트를 기준으로 왼쪽 오른쪽으로 나눔 |
    | 나누어진 트리들은 똑같은 일을 반복                                  |
    #=====================================================================# 
    */
	return makeBinarySearchTree(nums);
};

function makeBinarySearchTree(nums) {
	if (nums.length === 0) return null;
	const rootPos = Math.floor(nums.length / 2);
	const rootTree = new TreeNode(nums[rootPos]);
	rootTree.left = makeBinarySearchTree(nums.slice(0, rootPos));
	rootTree.right = makeBinarySearchTree(nums.slice(rootPos + 1, nums.length));
	return rootTree;
}
