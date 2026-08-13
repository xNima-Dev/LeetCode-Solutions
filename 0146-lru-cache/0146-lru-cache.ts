class LRUNode {
    key: number;
    val: number;
    prev: LRUNode | null = null;
    next: LRUNode | null = null;

    constructor(key: number, val: number) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private capacity: number;
    private map: Map<number, LRUNode>;
    private head: LRUNode;
    private tail: LRUNode;

    constructor(capacity: number) {
        this.capacity = capacity;
        this.map = new Map();

        this.head = new LRUNode(0, 0);
        this.tail = new LRUNode(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    get(key: number): number {
        if (!this.map.has(key)) {
            return -1;
        }

        const node = this.map.get(key)!;
        this.moveToHead(node);
        return node.val;
    }

    put(key: number, value: number): void {
        if (this.map.has(key)) {
            const node = this.map.get(key)!;
            node.val = value;
            this.moveToHead(node);
        } else {
            if (this.map.size === this.capacity) {
                const lru = this.tail.prev!;
                this.removeNode(lru);
                this.map.delete(lru.key);
            }

            const newNode = new LRUNode(key, value);
            this.map.set(key, newNode);
            this.addToHead(newNode);
        }
    }

    private moveToHead(node: LRUNode): void {
        this.removeNode(node);
        this.addToHead(node);
    }

    private addToHead(node: LRUNode): void {
        node.next = this.head.next;
        node.prev = this.head;
        if (this.head.next) {
            this.head.next.prev = node;
        }
        this.head.next = node;
    }

    private removeNode(node: LRUNode): void {
        if (node.prev) {
            node.prev.next = node.next;
        }
        if (node.next) {
            node.next.prev = node.prev;
        }
    }
}