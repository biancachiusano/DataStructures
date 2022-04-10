public class FindMin<E> {

		private Compare<E> comp;
		private E saved;
		private int count;

		/**
		 * Class Constructor
		 * @param comp element passed, of any type
		 */
		public FindMin(Compare<E> comp) {
			this.comp = comp;
		}

		/**
		 * The saved element resets and count goes back to 0
		 */
		public void reset() {
			saved = null;
			count = 0;
		}

		/**
		 * Add method
		 * @param e element passed
		 */
		public void add(E e) {
			/**
			 * if the reset method had been called or it
			 * is the first element being added, this element will be saved
			 * as the smallest and the count will go up by one
			 */
			if(saved == null){
				saved = e;
				count = 1;
			} else {
				/**
				 * If the element is smaller than the one currently
				 * saved in the saved variable, this will be updated and the count
				 * will be reset to one.
				 */
				if(comp.smaller(e, saved)){
					saved = e;
					count = 1;
				} else if(comp.equal(saved, e)){
				/**
				 * If the element is equal to the saved smallest one
				 * the count will go up by one.
				 */
					count++;
				}
			}
		}

		public E getMinimum() {
			return saved;
		}

		public int getMinimumCount() {
			return count;
		}
	}
