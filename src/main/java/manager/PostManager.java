package manager;

import domain.AfishaFilm;


public class PostManager {

    private AfishaFilm[] items = new AfishaFilm[0];
    private int limit = 10;

    public int getLimit() {

        return limit;
    }

    public PostManager(int limit) {
        this.limit = limit;
    }

    public PostManager() {
    }

    public void save(AfishaFilm item) {
        AfishaFilm[] tmp = new AfishaFilm[items.length + 1];

        System.arraycopy(items, 0, tmp, 0, items.length);

        tmp[tmp.length - 1] = item;
        items = tmp;
    }


    public void add(AfishaFilm item) {
        AfishaFilm[] tmp = new AfishaFilm[items.length + 1];

        System.arraycopy(items, 0, tmp, 0, items.length);

        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public AfishaFilm[] getAll() {
        AfishaFilm[] result = new AfishaFilm[items.length];
        if (items.length <= 1) {
            return items;
        } else {
            for (int i = 0; i < result.length; i++) {
                int index = items.length - i - 1;
                result[i] = items[index];
            }
            return result;
        }
    }

    public AfishaFilm[] getLastItem() {
        int count = 0;
        if (items.length < limit && items.length > 1) {
            count = items.length;
        } else if (items.length == 1) {
            return items;
        } else {
            count = limit;
        }
        AfishaFilm[] result = new AfishaFilm[count];
        for (int i = 0; i <= count - 1; i++) {
            int index = count - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public AfishaFilm[] findAll() {

        return items;
    }

    public int checkId(int id) {
        int ifExists = 0;
        for (AfishaFilm item : items) {
            if (item.getId() == id) {
                ifExists++;
                break;
            }
        }
        return ifExists;
    }


    public void removeById(int id) {
        if (checkId(id) > 0) {
            AfishaFilm[] tmp = new AfishaFilm[items.length - checkId(id)];
            int index = 0;
            for (AfishaFilm item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }
}