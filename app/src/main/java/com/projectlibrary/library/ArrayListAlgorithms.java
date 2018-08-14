package com.projectlibrary.library;

import java.util.ArrayList;

public class ArrayListAlgorithms {

    //TODO - In the future, do this with template methods, will be better !!!
    ArrayListAlgorithms()
    {

    }

    public void bookSortById(ArrayList<Book> rhs) //Sorting the books by id
    {
        int s = rhs.size();
        Book swap;

        for(int i = 0; i < s-1; i++)
        {
            for(int j = 0; j < s-i-1; j++)
            {
                if(rhs.get(j).getID() >= rhs.get(j+1).getID())
                {
                    swap = rhs.get(j);
                    rhs.set(j, rhs.get(j+1));
                    rhs.set(j+1,swap);
                }
            }

        }
    }
    public int bookFind(ArrayList<Book> rhs, Book b) //Finding a book in an ArrayList
    {
        int r = b.getID(), start = 0, mid = rhs.size() /2, end = rhs.size() ;

        while(r != rhs.get(mid).getID())
        {
            if(r > rhs.get(mid).getID())
            {
                start = mid;
                mid = (start + end) /2;
            }
            else if(r < rhs.get(mid).getID())
            {
                end = mid;
                mid = (start + end) / 2;
            }
            else
            {
                return rhs.get(mid).getID();
            }
        }
        return mid;

    }
    public void bookInsertById(ArrayList<Book> rhs, Book b)
    {
        int bId = b.getID(), pos = 0, i = 0;

        //Checks where the book should be inserted at
        while(bId > rhs.get(i).getID())
        {
            i++;
            pos++;
        }
        rhs.add(pos, b);
    }
    public void bookRemoveById(ArrayList<Book> rhs, int b)
    {
        int pos = 0, i = 0;

        //Checks where the book should be inserted at
        while(b > rhs.get(i).getID())
        {
            i++;
            pos++;
        }
        rhs.remove(b);
    }

    public void achievemtnSortById(ArrayList<Achievement> rhs) //Sorting the books by id
    {
        int s = rhs.size();
        Achievement swap;

        for(int i = 0; i < s-1; i++)
        {
            for(int j = 0; j < s-i-1; j++)
            {
                if(rhs.get(j).getID() >= rhs.get(j+1).getID())
                {
                    swap = rhs.get(j);
                    rhs.set(j, rhs.get(j+1));
                    rhs.set(j+1,swap);
                }
            }

        }
    }
    public int achievementFind(ArrayList<Achievement> rhs, Achievement b) //Finding an achievemt in an ArrayList
    {
        int r = b.getID(), start = 0, mid = rhs.size() /2, end = rhs.size() ;

        while(r != rhs.get(mid).getID())
        {
            if(r > rhs.get(mid).getID())
            {
                start = mid;
                mid = (start + end) /2;
            }
            else if(r < rhs.get(mid).getID())
            {
                end = mid;
                mid = (start + end) / 2;
            }
            else
            {
                return rhs.get(mid).getID();
            }
        }
        return mid;

    }
    public void achievementInsertById(ArrayList<Achievement> rhs, Achievement b)
    {
        int bId = b.getID(), pos = 0, i = 0;

        //Checks where the book should be inserted at
        while(bId > rhs.get(i).getID())
        {
            i++;
            pos++;
        }
        rhs.add(pos, b);
    }
    public void achievementRemoveById(ArrayList<Achievement> rhs, int b)
    {
        int pos = 0, i = 0;

        //Checks where the book should be inserted at
        while(b > rhs.get(i).getID())
        {
            i++;
            pos++;
        }
        rhs.remove(b);
    }

    public void authorSortById(ArrayList<Author> rhs) //Sorting the books by id
    {
        int s = rhs.size();
        Author swap;

        for(int i = 0; i < s-1; i++)
        {
            for(int j = 0; j < s-i-1; j++)
            {
                if(rhs.get(j).getID() >= rhs.get(j+1).getID())
                {
                    swap = rhs.get(j);
                    rhs.set(j, rhs.get(j+1));
                    rhs.set(j+1,swap);
                }
            }

        }
    }
    public int authorFind(ArrayList<Author> rhs, Author b) //Finding an achievemt in an ArrayList
    {
        int r = b.getID(), start = 0, mid = rhs.size() /2, end = rhs.size() ;

        while(r != rhs.get(mid).getID())
        {
            if(r > rhs.get(mid).getID())
            {
                start = mid;
                mid = (start + end) /2;
            }
            else if(r < rhs.get(mid).getID())
            {
                end = mid;
                mid = (start + end) / 2;
            }
            else
            {
                return rhs.get(mid).getID();
            }
        }
        return mid;

    }
    public void authorInsertById(ArrayList<Author> rhs, Author b)
    {
        int bId = b.getID(), pos = 0, i = 0;

        //Checks where the book should be inserted at
        while(bId > rhs.get(i).getID())
        {
            i++;
            pos++;
        }
        rhs.add(pos, b);
    }
    public void authorRemoveById(ArrayList<Author> rhs, int b)
    {
        int pos = 0, i = 0;

        //Checks where the book should be inserted at
        while(b > rhs.get(i).getID())
        {
            i++;
            pos++;
        }
        rhs.remove(b);
    }

    public void friendSortById(ArrayList<Friend> rhs) //Sorting the books by id
    {
        int s = rhs.size();
        Friend swap;

        for(int i = 0; i < s-1; i++)
        {
            for(int j = 0; j < s-i-1; j++)
            {
                if(rhs.get(j).getID() >= rhs.get(j+1).getID())
                {
                    swap = rhs.get(j);
                    rhs.set(j, rhs.get(j+1));
                    rhs.set(j+1,swap);
                }
            }

        }
    }
    public int friendFind(ArrayList<Friend> rhs, Friend b) //Finding an achievemt in an ArrayList
    {
        int r = b.getID(), start = 0, mid = rhs.size() /2, end = rhs.size() ;

        while(r != rhs.get(mid).getID())
        {
            if(r > rhs.get(mid).getID())
            {
                start = mid;
                mid = (start + end) /2;
            }
            else if(r < rhs.get(mid).getID())
            {
                end = mid;
                mid = (start + end) / 2;
            }
            else
            {
                return rhs.get(mid).getID();
            }
        }
        return mid;

    }
    public void friendInsertById(ArrayList<Friend> rhs, Friend b)
    {
        int bId = b.getID(), pos = 0, i = 0;

        //Checks where the book should be inserted at
        while(bId > rhs.get(i).getID())
        {
            i++;
            pos++;
        }
        rhs.add(pos, b);
    }
    public void friendRemoveById(ArrayList<Friend> rhs, int b)
    {
        int pos = 0, i = 0;

        //Checks where the book should be inserted at
        while(b > rhs.get(i).getID())
        {
            i++;
            pos++;
        }
        rhs.remove(b);
    }

    public void reviewSortById(ArrayList<Review> rhs) //Sorting the books by id
    {
        int s = rhs.size();
        Review swap;

        for(int i = 0; i < s-1; i++)
        {
            for(int j = 0; j < s-i-1; j++)
            {
                if(rhs.get(j).getID() >= rhs.get(j+1).getID())
                {
                    swap = rhs.get(j);
                    rhs.set(j, rhs.get(j+1));
                    rhs.set(j+1,swap);
                }
            }

        }
    }
    public int reviewFind(ArrayList<Review> rhs, Review b) //Finding an achievemt in an ArrayList
    {
        int r = b.getID(), start = 0, mid = rhs.size() /2, end = rhs.size() ;

        while(r != rhs.get(mid).getID())
        {
            if(r > rhs.get(mid).getID())
            {
                start = mid;
                mid = (start + end) /2;
            }
            else if(r < rhs.get(mid).getID())
            {
                end = mid;
                mid = (start + end) / 2;
            }
            else
            {
                return rhs.get(mid).getID();
            }
        }
        return mid;

    }
    public void reviewInsertById(ArrayList<Review> rhs, Review b)
    {
        int bId = b.getID(), pos = 0, i = 0;

        //Checks where the book should be inserted at
        while(bId > rhs.get(i).getID())
        {
            i++;
            pos++;
        }
        rhs.add(pos, b);
    }
    public void reviewRemoveById(ArrayList<Review> rhs, int b)
    {
        int pos = 0, i = 0;

        //Checks where the book should be inserted at
        while(b > rhs.get(i).getID())
        {
            i++;
            pos++;
        }
        rhs.remove(b);
    }
}
