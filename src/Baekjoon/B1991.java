package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	66117	43016	33095	67.073%
문제
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.



예를 들어 위와 같은 이진 트리가 입력되면,

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

입력
첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현한다.

출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 첫 번째 줄에서 노드 개수 입력 받기

        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 각 줄의 입력 처리
            String root = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();

            tree.addNode(root, leftNode, rightNode); // 트리에 추가
        }

        tree.preOrder(tree.getRoot());
        System.out.println(); // 전위 순회 결과 출력 후 줄 바꿈

        tree.inOrder(tree.getRoot());
        System.out.println(); // 중위 순회 결과 출력 후 줄 바꿈

        tree.postOrder(tree.getRoot());
        System.out.println(); // 후위 순회 결과 출력 후 줄 바꿈

    }
}

/// 재귀적 데이터 구조
class Node {
    String root;
    Node left;
    Node right;

    public Node(String root) {
        this.root = root;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    private Node root; // 트리의 루트 노드

    // 생성자
    public Tree() {
        this.root = null;
    }

    /// 트리 구성 메서드
    public void addNode(String head, String left, String right) {
        if (root == null) {
            root = new Node(head);
        }

        if (!left.equals(".")) searchNode(root, head, left, ".");
        if (!right.equals(".")) searchNode(root, head, ".", right);
    }


    ///  재귀적으로 트리를 탐색
    /// 입력받은 parent와 동일한 값을 가진 노드를 찾음
    /// 해당 부모 노드를 찾으면, 입력받은 leftNode와 rightNode를 연결
    private void searchNode(Node current, String parent, String leftNode, String rightNode) {
        if (current == null) return; // 현재 탐색 중인 노드가 비어있으면 더이상 찾을 이유가 없으니 종료

        if (current.root.equals(parent)) { // 현재 노드의 루트값이 입력받은 부모와 같을 때
            // 부모 노드와 자식 노드 연결
            if (!leftNode.equals(".")) current.left = new Node(leftNode);
            if (!rightNode.equals(".")) current.right = new Node(rightNode);
        } else { // 현재 노드의 루트 값과 입력받은 부모가 다르다

            // 왼쪽 우선으로 찾기
            searchNode(current.left, parent, leftNode, rightNode);
            // 왼쪽에서 못찾으면 이 곳으로 다시 종료되어 회귀하고 밑에 오른쪽 노드를 찾는 코드 실행
            searchNode(current.right, parent, leftNode, rightNode);
        }
    }

    /// 전위
    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.root); // 현재 노드 출력
        preOrder(node.left); // 왼쪽 먼저
        preOrder(node.right); // 마지막 오른쪽
    }

    /// 중위
    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left); // 왼쪽 먼저
        System.out.print(node.root); // 현재 노드 출력
        inOrder(node.right); // 마지막 오른쪽
    }

    /// 후위
    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);  // 왼쪽 먼저
        postOrder(node.right); // 그 다음 오른쪽
        System.out.print(node.root); // 현재 노드 출력
    }


    /// 루트 노드를 가져오는 메서드
    public Node getRoot() {
        return root;
    }
}
