package com.xuggle.mediatool;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * An abstract implementation of all
 * {@link IMediaGenerator} methods, but does not declare
 *  {@link IMediaGenerator}.
 *  
 * <p>
 * 
 * This class manages all attached {@link IMediaListener} objects in a
 * thread-safe set. The is fast to iterate over -- at the expense of a copy on
 * {@link #addListener(IMediaListener)} and
 * {@link #removeListener(IMediaListener)}.
 * 
 * </p>
 * 
 * <p>
 * 
 * Mixin classes can be extended by anyone, but the extending class
 * gets to decide which, if any, of the interfaces they actually
 * want to support.
 * 
 * </p>
 * 
 * @author trebor
 * @author aclarke
 *
 */

public abstract class AMediaGeneratorMixin
{

  private final Collection<IMediaListener> mListeners = new CopyOnWriteArrayList<IMediaListener>();

  /**
   * Create an {@link AMediaGeneratorMixin}.
   */
  public AMediaGeneratorMixin()
  {
    super();
  }

  /**
   * Adds this listener to a thread-safe set.
   * 
   * @return true if the set was modified when adding this call.
   */
  public boolean addListener(IMediaListener listener)
  {
    return mListeners.add(listener);
  }

  /**
   * Remove this listener from the thread-safe set of {@link IMediaListener} objects.
   * 
   * @return true if the set was modified by this call.
   */
  public boolean removeListener(IMediaListener listener)
  {
    return mListeners.remove(listener);
  }

  /**
   * Get a read-only collection of added {@link IMediaListener} objects.
   * 
   * @return a read-only collection of {@link IMediaListener} objects.
   */
  public Collection<IMediaListener> getListeners()
  {
    return Collections.unmodifiableCollection(mListeners);
  }

}
