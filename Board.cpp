#include "Header.h"
#include "Board.h"


Line::Line(unsigned size)
    :lineSize(size)
{
    Fields = new GameObject*[lineSize];
}


GameObject* &Line::operator[](unsigned index)
{
    return Fields[index];
}


Board::Board(unsigned x, unsigned y, unsigned obsChance = 10)
    :X(x), Y(y)
{
    Rows = new Line[X];
    for(unsigned int i = 0; i < X; i++)
    {
        Rows[i] = Line(Y);
        for(unsigned int k = 0; k < Y; k++)
          Rows[i][k] = new GameObject((i != 0 && i != X-1) && (rand() % obsChance == 0) ? "Obstacle" : "Field");
    }
}


Line::~Line()
{
    for(unsigned int i = 0; i < lineSize; i++)
        delete Fields[i];

    delete[] Fields;
}


Board::~Board()
{
    delete[] Rows;
}

Line& Board::operator[](unsigned index)
{
    return Rows[index];
}












