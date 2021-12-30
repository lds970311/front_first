<?php

class TreeNode
{
    public int $element;
    public TreeNode $parent;
    public TreeNode $left;
    public TreeNode $right;

    /**
     * @param int $element
     * @param BinarySearchTree $parent
     */
    public function __construct(int $element, TreeNode $parent)
    {
        $this->element = $element;
        $this->parent = $parent;
    }
}