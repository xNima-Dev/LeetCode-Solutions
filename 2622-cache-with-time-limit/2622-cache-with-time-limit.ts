class TimeLimitedCache {
    private cache: Map<number, { value: number; timer: ReturnType<typeof setTimeout> }>;

    constructor() {
        this.cache = new Map();
    }

    set(key: number, value: number, duration: number): boolean {
        const hasUnexpiredKey = this.cache.has(key);

        if (hasUnexpiredKey) {
            clearTimeout(this.cache.get(key)!.timer);
        }

        const timer = setTimeout(() => {
            this.cache.delete(key);
        }, duration);

        this.cache.set(key, { value, timer });

        return hasUnexpiredKey;
    }

    get(key: number): number {
        if (this.cache.has(key)) {
            return this.cache.get(key)!.value;
        }
        return -1;
    }

    count(): number {
     
        return this.cache.size;
    }
}
