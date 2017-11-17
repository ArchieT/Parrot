#include "Header.h"


bool Warrior::canAttak(int positionX, int positionY, int targetX, int targetY)
{
    double X = pow((positionX - targetX), 2);
    double Y = pow((positionY - targetY), 2);

    double required = sqrt(X + Y);

    return required > 1 && required < 2;
}

bool Spearman::canAttak(int positionX, int positionY, int targetX, int targetY)
{
    positionX -= targetX;
    if (positionX < 0) targetX *= -1;
    positionY -= targetY;
    if (positionY < 0) positionY *= -1;

    return (positionX == 2 && positionY == 0)
      || (positionX == 0 && positionY == 2);
}

bool Archer::canAttak(int positionX, int positionY, int targetX, int targetY)
{
    positionX -= targetX;
    positionY -= targetY;

    return positionX == targetX || positionY == targetY;
}

bool Horseman::canAttak(int positionX, int positionY, int targetX, int targetY)
{
    positionX -= targetX;
    positionY -= targetY;

    return positionX == targetX || positionY == targetY;
}

bool Wartiger::canAttak(int positionX, int positionY, int targetX, int targetY)
{
    positionX = positionX - targetX;
    if (positionX < 0) targetX *= -1;
    positionY = positionY - targetY;
    if (positionY < 0) positionY *= -1;

    return positionX == positionY;
}

bool Knight::canAttak(int positionX, int positionY, int targetX, int targetY)
{
    positionX -= targetX;
    if (positionX < 0) targetX *= -1;
    positionY -= targetY;
    if (positionY < 0) positionY *= -1;

    return positionX <= 1 && positionY <= 1;
}

bool King::canAttak(int positionX, int positionY, int targetX, int targetY)
{
    positionX -= targetX;
    if (positionX < 0) targetX *= -1;
    positionY -= targetY;
    if (positionY < 0) positionY *= -1;

    return (positionX <= 1 && positionY <= 1);
}
