/**
 * Portions Copyright 2006 DFKI GmbH.
 * Portions Copyright 2001 Sun Microsystems, Inc.
 * Portions Copyright 1999-2001 Language Technologies Institute, 
 * Carnegie Mellon University.
 * All Rights Reserved.  Use is subject to license terms.
 * 
 * Permission is hereby granted, free of charge, to use and distribute
 * this software and its documentation without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of this work, and to
 * permit persons to whom this work is furnished to do so, subject to
 * the following conditions:
 * 
 * 1. The code must retain the above copyright notice, this list of
 *    conditions and the following disclaimer.
 * 2. Any modifications must be clearly marked as such.
 * 3. Original authors' names are not deleted.
 * 4. The authors' names are not used to endorse or promote products
 *    derived from this software without specific prior written
 *    permission.
 *
 * DFKI GMBH AND THE CONTRIBUTORS TO THIS WORK DISCLAIM ALL WARRANTIES WITH
 * REGARD TO THIS SOFTWARE, INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS, IN NO EVENT SHALL DFKI GMBH NOR THE
 * CONTRIBUTORS BE LIABLE FOR ANY SPECIAL, INDIRECT OR CONSEQUENTIAL
 * DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR
 * PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS
 * ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF
 * THIS SOFTWARE.
 */
package de.dfki.lt.mary.unitselection.viterbi;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import de.dfki.lt.mary.unitselection.Target;
 /**
  * Represents a point in the Viterbi path. A point corresponds to an item,
  * e.g. a Segment.
  * Each ViterbiPoint knows
  * about its next ViterbiPoint, i.e. they can form a queue.
  */
 public class ViterbiPoint {
     private Target target = null;
     private ViterbiCandidate[] candidates = null;
     private SortedSet<ViterbiPath> paths = new TreeSet<ViterbiPath>(new Comparator<ViterbiPath>() {
         public int compare(ViterbiPath p1, ViterbiPath p2)
         {
             // big is bad:
             return Double.compare(p1.getScore(), p2.getScore());
         }
     });
     private ViterbiPoint next = null;
	
     /**
 	 * Gets the target of this point
 	 * @return the target
 	 */
 	public Target getTarget(){
 	    return target;
 	}
 	
 	/**
 	 * Sets the target of this point
 	 * @param target the new target
 	 */
 	public void setTarget(Target target){
 	    this.target = target;
 	}
     
 	 /**
 	 * Gets the candidates of this point
 	 * @return the candidates
 	 */
     public ViterbiCandidate[] getCandidates()
     {
 	    return candidates;
 	}
 	
     /**
      * Sets the candidates of this point
      * @param cands the candidates
      */
 	public void setCandidates(ViterbiCandidate[] candidates){
 	    this.candidates = candidates;
 	}
    
	 /**
 	 * Gets the sorted set containting the paths of the candidates of this point,
     * sorted by score. getPaths().first() will return the path with the lowest
     * score, i.e. the best path.
 	 * @return a sorted set.
 	 */
	public SortedSet getPaths(){
	    return paths;
	}
	
	/**
	 * Gets the next point in the queue
	 * @return the next point
	 */
	public ViterbiPoint getNext(){
	    return next;
	}
	
	/**
	 * Sets the next point in the queue
	 * @param next the next point
	 */
	public void setNext(ViterbiPoint next){
	    this.next = next;
	}
	
	/**
	 * Creates a ViterbiPoint for the given target. A typical 
	 * target may represent a phone, i.e. an Item in the Segment relation.
	 *
	 * @param target the target of interest
	 */
	public ViterbiPoint(Target target) {
	    this.target = target;
	}
	
	
	
	public String toString() {
	    return "ViterbiPoint: target " + target + "; " + paths.size() + " paths";
		}
 }
 